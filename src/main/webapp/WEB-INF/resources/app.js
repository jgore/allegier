import React from 'react'
import ReactDOM from "react-dom";
import {
    BrowserRouter as Router,
    Route,
    Link
} from 'react-router-dom';
import Pagination from 'react-paginate';

class App extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            products: [],
            pageRangeDisplayed: 100,
            marginPagesDisplayed: 20,
            activePage: 0,

            pageCount: 20,
            productPerPage: 50,
            productCount: 100
        };
        this.onPageChange = this.onPageChange.bind(this);

    }

    onPageChange(pageNumber) {
        console.log(`active page is ${pageNumber.selected}`);
        this.setState({activePage: pageNumber.selected});
        this.loadCountProducts();
        this.loadProductsFromServer();
    }

    loadCountProducts() {
        let self = this;
        fetch('rest/products?count=true', {
                headers: {
                    'Authorization': 'Basic ' + btoa('admin:admin'),
                    'Content-Type': 'application/x-www-form-urlencoded'
                },
            }
        )
            .then(function (response) {
                console.log(response);
                return response.json();
            })
            .then(function (data) {
                    self.setState({productCount: data})
                }
            );
    }

    loadProductsFromServer() {
        let self = this;
        fetch('rest/products?size=' + self.state.productPerPage + '&page=' + self.state.activePage, {
                headers: {
                    'Authorization': 'Basic ' + btoa('admin:admin'),
                    'Content-Type': 'application/x-www-form-urlencoded'
                },
            }
        )
            .then(function (response) {
                console.log(response);
                return response.json();
            })
            .then(function (data) {
                    self.setState({
                        products: data,
                        pageCount: Math.floor(self.state.productCount / self.state.productPerPage)
                    });
                }
            );
    }

    componentDidMount() {
        this.loadProductsFromServer();
    }

    render() {
        return (
            <div>
                <ProductsTable products={this.state.products}/>

                <Pagination
                    initialPage={0}
                    pageCount={this.state.pageCount}
                    pageRangeDisplayed={this.state.pageRangeDisplayed}
                    marginPagesDisplayed={this.state.marginPagesDisplayed}
                    onPageChange={this.onPageChange}

                    previousLabel={"previous"}
                    nextLabel={"next"}
                    breakLabel={<a href="">...</a>}
                    breakClassName={"break-me"}

                    containerClassName={"pagination"}
                    subContainerClassName={"pages pagination"}
                    activeClassName={"active"}
                />
            </div>
        );
    }

}


class ProductsTable extends React.Component {

    render() {
        let rows = [];
        this.props.products.forEach(function (product) {
            rows.push(<Product product={product}/>);
        });
        return (
            <div className="container">
                <table className="table table-striped">
                    <thead>
                    <tr>
                        <th>Title</th>
                        <th>Price</th>
                        <th>Category</th>
                    </tr>
                    </thead>
                    <tbody>{rows}</tbody>
                </table>
            </div>
        );
    }
}


class Product extends React.Component {

    constructor(props) {
        super(props);
        this.state = {display: true};
        this.handleDelete = this.handleDelete.bind(this);
        this.handleBuy = this.handleBuy.bind(this);
    }

    handleDelete() {
        fetch(this.props.product.link + "/" + this.props.product.id, {method: 'DELETE'})
            .then(function (response) {
                return response;
            })
            .then(function (response) {
                console.log(response);
                window.location.reload();
            })
    }

    handleBuy() {
        fetch("user/orders" + "/" + this.props.product.id, {
            headers: {
                'Authorization': 'Basic ' + btoa('admin:admin'),
                'Content-Type': 'application/x-www-form-urlencoded'
            },
            method: 'POST'
        })
            .then(function (response) {
                return response;
            })
            .then(function (response) {
                console.log(response);
                window.location.reload();
            })
    }

    render() {
        if (this.state.display == false) return null;

        else return (
            <tr>
                <td>{this.props.product.title}</td>
                <td>{this.props.product.price}</td>
                <td>{this.props.product.category}</td>
                <td>
                    <button className="btn btn-info" onClick={this.handleBuy}>Buy</button>
                </td>
                <td>
                    <button className="btn btn-info" onClick={this.handleDelete}>Delete</button>
                </td>
            </tr>
        );
    }
}

ReactDOM.render((
    <Router>
        <App/>
    </Router>), document.getElementById('root')
);



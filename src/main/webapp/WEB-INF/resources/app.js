import React from 'react'
import ReactDOM from "react-dom";
import {
    BrowserRouter as Router,
    Route,
    Link
} from 'react-router-dom';

class App extends React.Component {

    constructor(props) {
        super(props);
        this.state = {products: []};

    }

    loadProductsFromServer() {
        let self = this;
        fetch('http://localhost:8081/allegier/rest/products')
            .then(function (response) {
                console.log(response);
                return response.json();
            })
            .then(function (data) {
                    self.setState({products: data})
                }
            );
    }

    componentDidMount() {
        this.loadProductsFromServer();
    }

    render() {
        return (<ProductsTable products={this.state.products}/>);
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

    render() {
        if (this.state.display == false) return null;

        else return (
            <tr>
                <td>{this.props.product.title}</td>
                <td>{this.props.product.price}</td>
                <td>{this.props.product.category}</td>
                <td>
                    <button className="btn btn-info" onClick={this.handleDelete}>Delete</button>
                </td>
            </tr>
        );
    }
}

ReactDOM.render((
    <Router>
        <App />
    </Router> ), document.getElementById('root')
);




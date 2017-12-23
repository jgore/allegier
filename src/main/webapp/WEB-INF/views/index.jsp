<!DOCTYPE html>
<html>
<head>
    <title>React + Spring</title>
</head>
<body>
<div id='root'></div>

<script src="https://fb.me/react-15.0.1.js"></script>
<script src="https://fb.me/react-dom-15.0.1.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/babel-core/5.8.23/browser.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<script type="text/babel">

    let App = React.createClass({

        loadEmployeesFromServer: function () {
            let self = this;
            $.ajax({
                url: "http://localhost:8081/allegier/rest/products"
            }).then(function (data) {
                self.setState({products: data});
                console.log(data);
            });
        },

        getInitialState: function () {
            return {products: []};
        },

        componentDidMount: function () {
            this.loadEmployeesFromServer();
        },

        render() {
            return ( <ProductsTable products={this.state.products}/> );
        }

    });

    let Product = React.createClass({
        render: function() {
            return (
                <tr>
                    <td>{this.props.product.title}</td>
                    <td>{this.props.product.price}</td>
                    <td>{this.props.product.category}</td>
                </tr>);
        }
    });

    let ProductsTable = React.createClass({
        render: function() {
            let rows = [];
            this.props.products.forEach(function(product) {
                rows.push(<Product product={product} />);
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
    });

    ReactDOM.render(
        <App/>, document.getElementById('root')
    );

</script>

</body>
</html>
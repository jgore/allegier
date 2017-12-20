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
            var self = this;
            $.ajax({
                url: "http://localhost:8080/allegier/rest/products"
            }).then(function (data) {
                self.setState({employees: data._embedded.employees});
            });
        },

        getInitialState: function () {
            return {employees: []};
        },

        componentDidMount: function () {
            this.loadEmployeesFromServer();
        },

        render() {
            return ( <EmployeeTable employees={this.state.employees}/> );
        }
    });

    let Employee = React.createClass({
        render: function() {
            return (
                <tr>
                    <td>{this.props.employee.name}</td>
                    <td>{this.props.employee.age}</td>
                    <td>{this.props.employee.years}</td>
                </tr>);
        }
    });

    let EMPLOYEES = [
        {name: 'Joe Biden', age: 45, years: 5},
        {name: 'President Obama', age: 54, years: 8},
        {name: 'Crystal Mac', age: 34, years: 12},
        {name: 'James Henry', age: 33, years: 2}
    ];
    let EmployeeTable = React.createClass({
        render: function() {
            let rows = [];
            this.props.employees.forEach(function(employee) {
                rows.push(<Employee employee={employee} />);
            });
            return (
                <div className="container">
                    <table className="table table-striped">
                        <thead>
                        <tr>
                            <th>Name</th>
                            <th>Age</th>
                            <th>Years</th>
                        </tr>
                        </thead>
                        <tbody>{rows}</tbody>
                    </table>
                </div>
            );
        }
    });

    ReactDOM.render(
        <EmployeeTable employees={EMPLOYEES} />, document.getElementById('root')
    );

</script>

</body>
</html>
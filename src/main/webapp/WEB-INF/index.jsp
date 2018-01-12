<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Allegier</title>
</head>
<body>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/2.1.3/toastr.min.css">

<div id='root'></div>
<script src="<c:url value="resources/bundle.js" />"></script>

<form action="logout" method="post">
    <input class="btn btn-danger center-block" type="submit" value="Logout" />
</form>


</body>
</html>
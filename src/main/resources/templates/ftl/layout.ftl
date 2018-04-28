<#macro myLayout>
<!DOCTYPE html>
<html >
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="Kanban">
    <meta name="author" content="Walter">
    
    <title>Hello world</title>



    <!-- Bootstrap core CSS -->
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

    <!-- Custom styles for this template -->
    <link rel="stylesheet" type="text/css" href='././css/login.css' />
    <script type="text/javascript" src="././js/login.js"></script>

</head>

<body>

<div class="container" >
    <#include "header.ftl"/>

    <div class="panel " >
    <#nested/>
    </div>

    <#include "footer.ftl"/>

</div> <!-- /container -->


</body>
</html>

</#macro>
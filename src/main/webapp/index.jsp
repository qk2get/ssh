<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-2.2.1.min.js"></script>
    <script type="text/javascript">
        $(function () {
                $("#show").hide();
                $("#btn").one("click", function () {
                    $("#show").show();
                    $.get(
                        "/toload",
                        function (data) {
                            $.each(data, function (index, user) {
                                $("#show").append(
                                    "<tr>" +
                                    "<td>" + user.id + "</td>" +
                                    "<td>" + user.name + "</td>" +
                                    "<td>" + user.sex + "</td>" +
                                    "<td>" + user.age + "</td>" +
                                    "<td>" + user.location + "</td>" +
                                    "</tr>"
                                );
                            });
                        },
                        "json"
                    );
                });
            }
        )
    </script>
</head>
<body>
<button id="btn">get Users</button>
<s:fielderror></s:fielderror>
<table id="show" cellpadding="10px" cellspacing="10px" style="border: 1px solid purple">
    <tr>
        <th>ID</th>
        <th>name</th>
        <th>sex</th>
        <th>age</th>
        <th>location</th>
    </tr>
</table>
</body>
</html>

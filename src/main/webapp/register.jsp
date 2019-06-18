<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="//malsup.github.com/jquery.form.js"></script>
<script>
<html>
<body>
<script>
function check(){
    var returnData = $.ajax({
        async: true,
        type: "POST",
        url: "http://localhost:8088/rest/registration/logins",
        contentType: "application/json; charset=utf-8",
        dataType: "json"
    });

    return returnData.then(function(response){ return response.d === 'success'; }, function(){ return false; });
}

$(document).ready(function () {
    var checkPromise = UserAuthorityCheck();
    checkPromise.then(isUserAuthority, function(){ isUserAuthority(false); });

    function isUserAuthority(response) {
        $('#btnsearch').prop('disabled', !response);
    }
});
</script>
<form action="/register" method="POST">
    <input type="text" name="login" onchange="check()"> login
    <br/>
    <input type="text" name="password"/> password
    <br/>
    <input type="text" name="address"/> address
    <br/>
    <input type="text" name="phone"/> phone
    <br/>
    <input type="submit" value="Submit"/>
</body>
</html>
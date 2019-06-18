<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" buffer="none" pageEncoding="UTF-8" %>
<html>
<head>
<link rel="shortcut icon" href="https://iconizer.net/files/Human_o2/orig/gnome-color-browser.png" type="image/png">
    <meta charset="utf-8">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <style>
        .form-control{
        width: 20%;
        }
        </style>
</head>
<body>
<div align="center" style="margin-top:20%; float:center;">

<form action="/login" method="POST">
    <div class="col-xs-2">
            <input style="margin:5px;" type="text" class="form-control" width="30" placeholder="Имя пользователя" aria-label="Username" aria-describedby="basic-addon1" name="login">
    </div>
    <div class="col-xs-2">
            <input style="margin:5px;" type="password" class="form-control" width="30" placeholder="Пароль" aria-label="Password" aria-describedby="basic-addon1" name="password">
    </div>
    <button style="margin:5px; display:inline;" type="submit" class="btn btn-success">Войти</button>
</form>
<form action="/register.jsp" method="POST">
<button style="margin:5px;" type="submit" class="btn btn-primary" >Регистрация</button>
</form>
</div>
</body>
</html>
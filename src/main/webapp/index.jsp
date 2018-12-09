<html>
<head>
<title>Login Trader</title>
</head>
<body>
   <center style="margin-top: 80px"><div>
   
<img src="C:\Users\Admin\Desktop\images.png">
   <h2>LOGIN</h2>
     <form action = "LoginTraderServlet" method= "post">
     <h3>username: <input type = "text" id = "user" name ="username" placeholder = "inserisci username"></h3>
     <h3>password: <input type = "password" id = "pass" name ="password" placeholder = "inserisci password"></h3>
     <button type = "submit" value = "Login" name = "richiestaLogin">Login</button><br>
     <!-- <a href="register.jsp" name = "registrati"> Registrati </a>  -->
     </form>
     
      <form action = "LoginTraderServlet" method= "post">
      	<button type = "Registrati" value = "Registrati" name = "richiestaLogin">Registrati</button><br>
      </form>
   </div></center>
</body>
</html>
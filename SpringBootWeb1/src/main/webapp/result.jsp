<%@page language="java" %>
<html>
	<head>
		<style>
			@import url('https://fonts.googleapis.com/css2?family=Roboto+Condensed:ital,wght@0,100..900;1,100..900&display=swap');
			*{
			    margin: 0;
			    padding: 0;
			    box-sizing: border-box;
			}
			body{
			    background-image:linear-gradient(#1c92d2,#f2fcfe);
			    background-repeat: no-repeat;
			}
			.wrapper{
			    width: 100%;
			    height: 575px;
			}
			.box{
			    background-image:linear-gradient(#3A1C71,#D76D77,#FFAF7B);
			    background-color: antiquewhite;
			    width: 40%;
				height:500px;
			    border: 1px solid lightgray;
			    margin: auto;
			    margin-top: 10%;
			}
			.forms{
			    text-align: center;
			    margin: 20px;
			   
			}
			form .leb
			{
			    display: flex;
			    justify-content: space-around;
			    padding: 15px;
			}
			form .leb select{
			    padding:0 15px;
			}
			h1{
			    text-align: center;
			}
			form .leb label{
			    padding: 5px;
			    justify-content: center;
			}
			form .leb .input
			{
			    padding: 5px;
			    justify-content: center;
			}

		</style>
	</head>
	

	<body>
		<h1> Result is =>> <%= session.getAttribute("result") %> <h1>
			// or we can use
		<h1> Result is =>> ${result} <h1>
			
	</body>
</html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>StartPage</title>
		<link rel="stylesheet" href="static/css/mainPageStyle.css" type="text/css">
		<script src="/static/js/script.js"></script>
	</head>
	<body onload="directoriesAndTypesConstruct(employees)">
		<div class="container">
			<div id="menu">
			</div>
			<div id="main">
				<div id="directories_and_types_explorer">
					<div class="directories_explorer">
						<ul id="directory_root"></ul>
					</div>
					
					<div id="types_explorer">
					<ul id="types_root"></ul>
					</div>
				</div>
				<div id="content">
				</div>
			</div>
		</div>
	</body>
</html>
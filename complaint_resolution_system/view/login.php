<?php
	include_once('config.php');
	include_once('login_controller.php');

	$login_controller = new LoginController();
	echo json_encode($login_controller->validate());

?>
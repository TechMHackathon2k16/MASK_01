<?php
	include_once('config.php');
	include_once(ROOT_DIR.'controller/login_controller.php');

	$login_controller = new LoginController();
	echo json_encode($login_controller->invoke());

?>
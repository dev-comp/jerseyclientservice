/* ��� ��� ������� �� ���������������� �� ���������� */
var OUR_REG_NAME = "Andrey";
/* api ��� ��������� ����� ������������� */
var GET_USERS_URL = "http://172.21.21.249:8080/botservice/rs/api/userKeyList/" + OUR_REG_NAME;
var GET_USERS_URL_TEST = "rest/get/clientlist";
/* api ��� ��������� ���� */
var GET_LOG_URL = "";
var GET_LOG_URL_TEST = "rest/get/incominglog/";
/* api ��� �������� ��������� ����������� ������������ */
var POST_SENDMSG_URL = "http://172.21.21.249:8080/botservice/rs/api/sendMsg";
var POST_SENDMSG_URL_TEST = "rest/get/sendmsg/";

/* api ��� ������� � ����� */
var POST_OURBOTAPI_URL_LOCAL = "rest/testbot/";
var POST_OURBOTAPI_URL = "http://172.21.20.111:8081/rest/testbot";


/* ��������� ����������� ��������� */
toastr.options = {
	"closeButton": true,
	"positionClass": "toast-top-right"
};

/**
 * ������� ������ ��������� ������� � ������������ ����
 * @param jqXHR ��������� ������
 * @param exception ��� ������
 * @returns {string}
 */
function formatErrorMessage(jqXHR, exception) {
	if (jqXHR.status === 0) {
		return ('Not connected.\nPlease verify your network connection.');
	} else if (jqXHR.status == 404) {
		return ('The requested page not found. [404]');
	} else if (jqXHR.status == 500) {
		return ('Internal Server Error [500].');
	} else if (exception === 'parsererror') {
		return ('Requested JSON parse failed.');
	} else if (exception === 'timeout') {
	  return ('Time out error.');
	} else if (exception === 'abort') {
		return ('Ajax request aborted.');
	} else {
		return ('Uncaught Error.\n' + jqXHR.responseText);
	}
}

/* �� �������������� */
function getBrowser() {
	if (navigator.userAgent.toLowerCase().indexOf('chrome') > -1)
	  return "Chrome";
	else if (navigator.userAgent.toLowerCase().indexOf('firefox') > -1)
	  return "Firefox";
	else
		return "Unknown browser";
}

/**
 * �������� labels (���� ������ ����������, � ����� ������ �������� ������ ������)
 */
jQuery(document).ready(function($){
	if( $('.floating-labels').length > 0 ) floatLabels();

	function floatLabels() {
		var inputFields = $('.floating-labels .cd-label').next();
		inputFields.each(function(){
			var singleInput = $(this);
			//check if user is filling one of the form fields
			checkVal(singleInput);
			singleInput.on('change keyup', function(){
				checkVal(singleInput);
			});
		});
	}

	function checkVal(inputField) {
		( inputField.val() == '' ) ? inputField.prev('.cd-label').removeClass('float') : inputField.prev('.cd-label').addClass('float');
	}
});
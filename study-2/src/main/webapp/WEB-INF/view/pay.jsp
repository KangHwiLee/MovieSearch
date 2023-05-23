<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<!-- iamport.payment.js -->
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
<script>
var IMP = window.IMP;
IMP.init("imp64361503");

function requestPay() {
	console.log("�۵�?")
    IMP.request_pay(
      {
        pg: "kakaopay.TC0ONETIME",
        pay_method: "card",
        merchant_uid: 'merchant_' + new Date().getTime(),
        name: "��� 10kg",
        amount: 1004,
        buyer_email: "Iamport@chai.finance",
        buyer_name: "��Ʈ�� ���������",
        buyer_tel: "010-1234-5678",
        buyer_addr: "����Ư���� ������ �Ｚ��",
        buyer_postcode: "123-456",
      },
      function (rsp) {
    	  if ( rsp.success ) {
              var msg = '������ �Ϸ�Ǿ����ϴ�.';
              //location.href='�����Ϸ��� �� url';
          } else {
              var msg = '������ �����Ͽ����ϴ�.';
              rsp.error_msg;
              
          }
      }
    );
  }

</script>
</head>
<body>
<button onclick="requestPay()">�����ϱ�</button>
</body>

</html>
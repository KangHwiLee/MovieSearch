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
	console.log("작동?")
    IMP.request_pay(
      {
        pg: "kakaopay.TC0ONETIME",
        pay_method: "card",
        merchant_uid: 'merchant_' + new Date().getTime(),
        name: "당근 10kg",
        amount: 1004,
        buyer_email: "Iamport@chai.finance",
        buyer_name: "포트원 기술지원팀",
        buyer_tel: "010-1234-5678",
        buyer_addr: "서울특별시 강남구 삼성동",
        buyer_postcode: "123-456",
      },
      function (rsp) {
    	  if ( rsp.success ) {
              var msg = '결제가 완료되었습니다.';
              //location.href='결제완료후 갈 url';
          } else {
              var msg = '결제에 실패하였습니다.';
              rsp.error_msg;
              
          }
      }
    );
  }

</script>
</head>
<body>
<button onclick="requestPay()">결제하기</button>
</body>

</html>
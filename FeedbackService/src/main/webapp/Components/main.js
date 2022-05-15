$(document).ready(function()
		{
	if ($("#alertSuccess").text().trim() == "")
	{
		$("#alertSuccess").hide();
	}
	$("#alertError").hide();
		});
//
// UPDATE==========================================
$(document).on("click", ".btnUpdate", function(event)
{
	 $("#hididUpdate").val($(this).data("id"));
	 $("#userid").val($(this).closest("tr").find('td:eq(0)').text());
 $("#previousbillno").val($(this).closest("tr").find('td:eq(1)').text());
 $("#amount").val($(this).closest("tr").find('td:eq(2)').text());
 $("#payedamount").val($(this).closest("tr").find('td:eq(3)').text());
 $("#balance").val($(this).closest("tr").find('td:eq(4)').text());
 $("#newbillno").val($(this).closest("tr").find('td:eq(5)').text());
 $("#newamount").val($(this).closest("tr").find('td:eq(6)').text());
 $("#total").val($(this).closest("tr").find('td:eq(7)').text());
 $("#comment").val($(this).closest("tr").find('td:eq(8)').text());
});

//
// validate Feedback form [CLIENT-MODEL]
//
function validatepowerusageDataForm()
{
// USERID
if ($("#userid").val().trim() == "")
 {
 return "Insert user id number.";
 }
// PREVIOUS BILLL NO
if ($("#previousbillno").val().trim() == "")
 {
 return "Insert previous bill number.";
 }
// AMOUNT
if ($("#amount").val().trim() == "")
 {
 return "Insert amount.";
 }
 // PAID AMOUNT
if ($("#payedamount").val().trim() == "")
 {
 return "Insert the paid amount.";
 }
 // BALANCE
if ($("#balance").val().trim() == "")
 {
 return "Insert the balance.";
 }
 // NEW BILL NUMBER
if ($("#newbillno").val().trim() == "")
 {
 return "Insert the new bill number.";
 }
 // NEW AMOUNT
if ($("#newamount").val().trim() == "")
 {
 return "Insert the new amount.";
 }
  // TOATL AMOUNT
if ($("#total").val().trim() == "")
{
return "Insert the total value.";
}
 // COMMENT STATUS
 if ($("#comment").val().trim() == "")
 {
 return "Insert the comment.";
 }
return true;
}

/*** */
// SAVE ============================================
$(document).on("click", "#btnSave", function(event)
{
// Clear status msges-------------
 $("#alertSuccess").text("");
 $("#alertSuccess").hide();
 $("#alertError").text("");
 $("#alertError").hide();
// Form validation----------------
var status = validatepowerusageDataForm();
// If not valid-------------------
if (status != true)
 {
 $("#alertError").text(status);
 $("#alertError").show();
 return;
 }
// If valid-----------------------
//Insert part
 var type = ($("#hididUpdate").val() == "") ? "POST" : "PUT";
 $.ajax(
 {
 url : "FeedbackAPI",
 type : type,
 data : $("#formpowerusage").serialize(),
 dataType : "text",
 complete : function(response, status)
 {
 onpowerusagedataSaveComplete(response.responseText, status);
 }
 });
});

function onpowerusagedataSaveComplete(response, status)
{
if (status == "success")
 {
 var resultSet = JSON.parse(response);
 if (resultSet.status.trim() == "success")
 {
 $("#alertSuccess").text("Successfully saved.");
 $("#alertSuccess").show();
 $("#divpowerusageGrid").html(resultSet.data);
 } else if (resultSet.status.trim() == "error")
 {
 $("#alertError").text(resultSet.data);
 $("#alertError").show();
 }
 } else if (status == "error")
 {
 $("#alertError").text("Error while saving.");
 $("#alertError").show();
 } else
 {
 $("#alertError").text("Unknown error while saving..");
 $("#alertError").show();
 }
 14
 $("#hididUpdate").val("");
 $("#formpowerusage")[0].reset();
}


// Delete part
$(document).on("click", ".btnRemove", function(event)
		{
		 $.ajax(
		 {
		 url : "FeedbackAPI",
		 type : "DELETE",
		 data : "id=" + $(this).data("id"),
		 dataType : "text",
		 complete : function(response, status)
		 {
		 onpowerusagedataDeleteComplete(response.responseText, status);
		 }
		 });
		});
function onpowerusagedataDeleteComplete(response, status)
{
if (status == "success")
 {
 var resultSet = JSON.parse(response);
 if (resultSet.status.trim() == "success")
 {
 $("#alertSuccess").text("Successfully deleted.");
 $("#alertSuccess").show();
 $("#divpowerusageGrid").html(resultSet.data);
 } else if (resultSet.status.trim() == "error")
 {
 $("#alertError").text(resultSet.data);
 $("#alertError").show();
 }
 } else if (status == "error")
 {
 $("#alertError").text("Error while deleting.");
 $("#alertError").show();
 } else
 {
 $("#alertError").text("Unknown error while deleting..");
 $("#alertError").show();
 }
}

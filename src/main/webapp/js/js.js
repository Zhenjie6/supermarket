/**
 * Created by yaling.he on 2015/11/17.
 */

//供应商管理页面上点击删除按钮弹出删除框(providerList.jsp)
$(function () {
    $('.removeProvider').click(function () {
        $('.zhezhao').css('display', 'block');
        $('.theSupplierId').attr("param", this.attributes['param'].value);
        $('#removeProv').fadeIn();
    });
});

$(function () {
    $('#yesDelSupplier').click(function () {
        $('.zhezhao').css('display', 'none');
        $('#removeBi').fadeOut();
        $.ajax({url:"supplier?id=" + $('.theSupplierId').attr("param") +"&action=delete", async:false});
        location.href = "supplier?action=list";
    });
});

$(function () {
    $('#noDelSupplier').click(function () {
        $('.zhezhao').css('display', 'none');
        $('#removeBi').fadeOut();
    });
});


//订单管理页面上点击删除按钮弹出删除框(billList.jsp)
$(function () {
    $('.removeBill').click(function () {
        $('.zhezhao').css('display', 'block');
        $('.billId').attr("param", this.attributes['param'].value);
        $('#removeBi').fadeIn();
    });
});

$(function () {
    $('#yesDelBill').click(function () {
        $('.zhezhao').css('display', 'none');
        $('#removeBi').fadeOut();
        $.ajax({url:"bill?id=" + $('.billId').attr("param") +"&action=delete", async:false});
        location.href = "bill?action=list";
    });
});

$(function () {
    $('#noDelBill').click(function () {
        $('.zhezhao').css('display', 'none');
        $('#removeBi').fadeOut();
    });
});

//用户管理页面上点击删除按钮弹出删除框(userList.jsp)
$(function () {
    $('.removeUser').click(function () {
        $('.zhezhao').css('display', 'block');
        $('.theUserId').attr('param', this.attributes['param'].value);
        $('#removeBi').fadeIn();
    });
});

$(function () {
    $('#yesDelUser').click(function () {
        $('.zhezhao').css('display', 'none');
        $('#removeUse').fadeOut();
        $.ajax({url:"user?id=" + $('.theUserId').attr("param") +"&action=delete", async:false});
        location.href = "user?action=list";
    });
});

$(function () {
    $('#noDelUser').click(function () {
        $('.zhezhao').css('display', 'none');
        $('#removeUse').fadeOut();
    });
});


$(function () {
    $('.findUserByName').click(function () {
        location.href = "user?action=findUserByName&name="+$("input[type='text']").val();
    });
});

$(function () {
    $('.findSupplierByName').click(function () {
        location.href = "supplier?action=findSupplierByName&name="+$("input[type='text']").val();
    });
});

$(function () {
    $('.findBillByCondition').click(function () {
        location.href = "bill?action=findBillByCondition&good_name="+$("input[type='text']").val()
            +"&supplier_name="+$("#selName option:selected").val()+"&payment_status="+$("#selPayment option:selected").val();
    });
});
function reg(button) {
    var index = -1;
    for (var i = 0; i < cform.rbut.length; i++) {
        if (cform.rbut[i] == button) {
            index = i;
            break;
        }
    }
    var id = cform.id[index].value;
    document.cform.selectid.value = id;
    document.cform.op.value = "register";
    if(confirm("Click OK to Continue or Click Cancel to return")){
    	document.getElementById("cform").submit();
    }
}

function show(button) {
    var index = -1;
    for (var i = 0; i < cform.sbut.length; i++) {
        if (cform.sbut[i] == button) {
            index = i;
            break;
        }
    }
    var id = cform.id[index].value;
    document.cform.selectid.value = id;
    document.cform.op.value = "show";
    //alert(document.cform.op.value);
}

function drop(button) {
    var index = -1;
    for (var i = 0; i < cform.dbut.length; i++) {
        if (cform.dbut[i] == button) {
            index = i;
            break;
        }
    }
    var id = cform.id[index].value;
    document.cform.selectid.value = id;
    document.cform.op.value = "drop";
    if(confirm("Click OK to Continue or Click Cancel to return")){
    	document.getElementById("cform").submit();
    }
    //alert(document.cform.op.value);
}
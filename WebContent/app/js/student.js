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
    //alert(document.cform.op.value);
}
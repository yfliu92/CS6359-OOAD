(function ($, window, document) {
    var addUserBtn = ".add-user-btn";
    var addUserFormArea = "#add-user-form-area";

    var $ADD_USER_BTN = $(addUserBtn);
    var $ADD_USER_FORM_AREA = $(addUserFormArea);

    // add user form
    var admin_add_user_form = "#admin-add-user-form";
    var admin_add_user_form_btn = "#admin-add-user-form-btn";

    var $ADMIN_ADD_USER_FORM = $(admin_add_user_form);
    var $ADMIN_ADD_USER_FORM_BTN = $(admin_add_user_form_btn);

    var id = "#inputUserName";
    var pwd = "#inputPassword";
    var fname = "#inputFistName";
    var lname = "#inputLastName";
    var email = "#inputEmail";

    function showAdd() {
        $ADD_USER_FORM_AREA.css("display", "block");
    }

    $(function () {
        $('.admin-users').addClass('active');

        $ADD_USER_BTN.click(showAdd);

        $ADMIN_ADD_USER_FORM.on('click', admin_add_user_form_btn, function (e) {
            e.preventDefault();

            if ($(id).val() === "") {
                alert("User name must be filled out!");
                $(id).focus();
                return false;
            } else if ($(pwd).val() === "") {
                alert("Password must be filled out!");
                $(pwd).focus();
                return false;
            } else if ($(fname).val() === "") {
                alert("First Name must be filled out!");
                $(fname).focus();
                return false;
            } else if ($(lname).val() === "") {
                alert("Last Name must be filled out!");
                $(lname).focus();
                return false;
            } else if ($(email).val() === "") {
                alert("Email must be filled out!");
                $(email).focus();
                return false;
            } else {
                $ADMIN_ADD_USER_FORM.submit();
            }
        });
    });
})(window.jQuery, window, document);

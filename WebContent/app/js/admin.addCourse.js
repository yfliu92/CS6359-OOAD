(function ($, window, document) {
    var admin_add_course_form = "#admin-add-course-form";
    var admin_add_course_btn = ".admin-add-course-btn";

    var $ADMIN_ADD_COURSE_FORM = $(admin_add_course_form);
    var $ADMIN_ADD_COURSE_BTN = $(admin_add_course_btn);

    // form input
    var year = "#year";
    var semester = "#semester";
    var prefix = "#prefix";
    var number = "#number";
    var sec = "#sec";
    var cname = "#cname";
    var smonth = "#smonth";
    var sday = "#sday";
    var emonth = "#emonth";
    var eday = "#eday";
    var stime = "#stime";
    var s_time = "#s_time";
    var etime = "#etime";
    var e_time = "#e_time";
    var room = "#room";
    var capacity = "#capacity";

    $(function () {
        $('.admin-add-course').addClass('active');

        $ADMIN_ADD_COURSE_FORM.on('click', admin_add_course_btn, function (e) {
            e.preventDefault();

            if ($(year).val() === "" || $(year).val().length != 4) {
                alert("Please fill in year in the correct format!");
                $(year).focus();
                return false;
            } else if ($(semester).val() === "") {
                alert("Semester must be filled out!");
                $(semester).focus();
                return false;
            } else if ($(prefix).val() === "0") {
                alert("Please choose course prefix!");
                $(prefix).focus();
                return false;
            } else if ($(number).val() === "") {
                alert("Course number must be filled out!");
                $(number).focus();
                return false;
            } else if ($(sec).val() === "") {
                alert("Section number must be filled out!");
                $(sec).focus();
                return false;
            } else if ($(cname).val() === "") {
                alert("Course name must be filled out!");
                $(cname).focus();
                return false;
            } else if ($(smonth).val() === "0") {
                alert("Start month must be selected!");
                $(smonth).focus();
                return false;
            } else if ($(sday).val() === "0") {
                alert("Start day must be selected!");
                $(sday).focus();
                return false;
            } else if ($(emonth).val() === "0") {
                alert("End month must be selected!");
                $(emonth).focus();
                return false;
            } else if ($(eday).val() === "0") {
                alert("End day must be selected!");
                $(eday).focus();
                return false;
            } else if ($(stime).val() === "") {
                alert("Start time must be filled out!");
                $(stime).focus();
                return false;
            } else if ($(etime).val() === "") {
                alert("End time must be filled out!");
                $(etime).focus();
                return false;
            } else if ($(room).val() === "") {
                alert("Room must be filled out!");
                $(etime).focus();
                return false;
            } else if ($(capacity).val() === "" || isNaN(parseInt($(capacity).val())) || parseInt($(capacity).val()) <= 0) {
                alert("Capacity must be filled out in the correct format!");
                $(capacity).focus();
                return false;
            } else {
                $ADMIN_ADD_COURSE_FORM.submit();
            }

            // var s_time = "#s_time";
            // var e_time = "#e_time";
        });
    });

})(window.jQuery, window, document);

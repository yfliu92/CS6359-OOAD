(function($, window, document) {
    $(function() {
        $('.sidebar-home').addClass('active');
        TeacherLoad();
        $(".sidebar-profile").click(function (){
            GetProfile();
        });
    });
})(window.jQuery, window, document);
// $(document).ready(function () {
//     $('.sidebar-home').addClass('active');
//     TeacherLoad();
// });
function TeacherLoad(){
    //request for all the classes

    $.ajax({
        url:"teacherController",
        data: {"op":"loading"},
        success: function(data){
            //add the class to sidebar
            var jsonArray=$.parseJSON(data);
            $.each(jsonArray,function (index,jsonObject) {
                $(".sidebar-course").append("<p class=\"list-group-item list-group-item-action\" value=\""+jsonObject.cId+"\">"+jsonObject.cName+"</p>");
            });
            $(".sidebar-course p").click(function () {
                var cId=$(this).attr("value");
                courseDetail(cId);
            });
        },
        error: function () {
            alert("error loading file");
        }
    });
}
function GetProfile() {
    //request the teacher's profile

    // var id='<%= session.getAttribute("id")%>';
    $.ajax({
        url: "teacherController",
        data: {"op":"profile"},
        success:function (data) {
            //display profile
            var jsonObject=$.parseJSON(data);
            $(".page-content-container").empty();
            $(".page-content-container").append("<h6>First Name:"+jsonObject.firstName+"</h6>"+
                "<h6>Last Name:"+jsonObject.lastName+"</h6>"+"<h6>Email:"+jsonObject.email+"</h6>"+
                "<h6>School:"+jsonObject.school+"</h6>"+"<h6>Year:"+jsonObject.year+"</h6>");
        },
        error: function () {
            alert("error loading file");
        }
    });
}
function courseDetail(courseId) {
    //request course detail
    $.ajax({
        url: "teacherController",
        data: {"op":"courseDetail", "courseId":courseId},
        success:function (data) {
            //display course detail
            var jsonObject=$.parseJSON(data);
            $(".page-content-container").empty();

            $(".page-content-container").append("<h6>Course Name:"+jsonObject.cName+"</h6>"+
                "<h6>Course Number:"+jsonObject.pref+jsonObject.cNum+"."+jsonObject.sectionNum+"</h6>"+
                "<h6>Room:"+jsonObject.room+"</h6>"+"<h6>Capacity:"+jsonObject.capacity+"</h6>"+
                "<h6>Year&Semester:"+jsonObject.year+"/"+jsonObject.semester+"</h6>"+
                "<h6>Period:"+jsonObject.startDay+"-"+jsonObject.endDay+"</h6>"+
                "<h6>Time:"+jsonObject.startTime+"-"+jsonObject.endTime+"</h6>"+
                "<h6>Days:"+jsonObject.days+"</h6>"+"<h6>Teacher:"+jsonObject.teacher+"</h6>");
            $(".page-content-container").append("<button class=\"syllabus\" value="+jsonObject.syllabus+">Syllabus</button>");
            $(".syllabus").click(function () {
                var syllabus_id=$(this).attr("value");
                showSyllabus(syllabus_id);
            });
        },
        error: function () {
            alert("error loading file");
        }
    });
}
function showSyllabus(syllabusId) {
    $.ajax({
        url: "syllabusController",
        data: {"op":"syllabusDetail", "syllabusId":syllabusId},
        success:function (data) {
            //display syllabus
            var jsonObject=$.parseJSON(data);
            $(".page-content-container").empty();
            if(jsonObject.taName.length==0){
                $(".page-content-container").append("<h3>No syllabus</h3>");
            }
            else {
                $(".page-content-container").append("<h6>Description:" + jsonObject.description + "</h6>" +
                    "<h6>TA Name:" + jsonObject.taName + "</h6>" +
                    "<h6>TA Email:" + jsonObject.taEmail + "</h6>" + "<h6>Grading:" + jsonObject.grading + "</h6>");
            }
            $(".page-content-container").append("<button id=\"editSyllabus\" value="+jsonObject.syllabus_id+">Edit Syllabus</button>");
            $("#editSyllabus").click(function () {

                // editSyllabus(jsonObject.syllabus_id);
                $(location).attr("href","app/teacher/Syllabus.jsp?id="+jsonObject.syllabus_id);
            });
        },
        error: function () {
            alert("error loading file");
        }
    });
}
function editSyllabus(syllabusId){
    $.ajax({
        url: "syllabusController",
        data: {"op":"loading", "syllabusId":syllabusId},
        async: false,
        success:function (data) {
            // $(location).attr("href","app/teacher/Syllabus.jsp");
        },
        error: function () {
            alert("error loading file");
        }
    });
}
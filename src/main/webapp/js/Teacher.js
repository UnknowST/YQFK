$(function () {
    $.ajax({
        url:"get/find_t",
        type: "get",
        dataType: "json",
        async: true,
        success:function (list) {

            var kai1="<select id='collage'>"
            var jie1="</select>"
            var lis1;

            var kai2="<select id='tid'>"
            var jie2="</select>"
            var lis2;

            var kai3="<select id='tname'>"
            var jie3="</select>"
            var lis3;
            var num;
            var a=[];
            var li1=li="<option value="+0+">"+"</option>";
            $("#collage1").html(kai1+li1+jie1);
            $("#tname1").html(kai3+li1+jie3);
            $("#tid1").html(kai2+li1+jie2);
            for(var i=0;i<list.length;i++){
                a[i]=list[i].dept;    //json种的某列值读出
            }
            a=[...new Set(a)];   //数组转set去重复
            a=Array.from(a);      //set又转回数组

            for(var i=0;i<a.length;i++){
                li="<option value="+i+">"+a[i]+"</option>";
                lis1+=li;
            }

            $("#collage1").html(kai1+lis1+jie1);

            $("#collage").change(function () {    //监听select的值
                lis3=null;
                var collage=$("#collage option:selected").text();
                for(var i=0;i<list.length;i++){
                    if(list[i].dept==collage&&list[i].title=="辅导员"){
                        num=i;
                        var li="<option value="+i+">"+list[i].name+"</option>"
                        lis3+=li;
                    }
                }

                $("#tname1").html(kai3+lis3+jie3);

                $("#tname").change(function () {    //监听select的值
                    lis2=null;
                    var tname=$("#tname option:selected").text();

                    for(var i=0;i<list.length;i++){
                        if(list[i].name==tname){
                            var li="<option value="+i+">"+list[i].id+"</option>"
                            lis2+=li;
                        }
                    }

                    $("#tid1").html(kai2+lis2+jie2);
                })

            })

            //后两个同时改变的监听  待完善   第三列开始时不会根据第二列的元素变化而变化




        }
    })
})
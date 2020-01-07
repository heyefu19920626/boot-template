// 观点个数,初始为1
let OPTION_ITEM_INDEX = 1;

// 节点
let NODE;

// 画板宽高
let WIDTH = 680;
let HEIGHT = 400;

$(function () {
    //全局初始化日期插件
    $('.default-date').datetimepicker({
        format: "yyyy-mm-dd hh:ii:ss",
        language: 'zh-CN',
        weekStart: 1,
        todayBtn: 1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        // minView: 'second',
        forceParse: 0,
        // showMeridian: 1,
        minuteStep: 1
    });
    initCanvasSize();
    $('#save').click(function () {
        saveAppInfo();
    });
    $('#opacity_').change(function () {
        $('#opacity').val($('#opacity_').val() / 100)
    });
    initPicUpload("result_pic");
    initPicUpload("option_pic_0");

    NODE = initNodePosition();
    setPosition(NODE.getBound());
});

function initCanvasSize() {
    let view = $('#canvas');
    WIDTH = view.width();
    HEIGHT = view.height();
    view.attr('height', HEIGHT).attr('width', WIDTH);
}

/**
 * 保存应用信息.
 */
function saveAppInfo() {
    verifyNull();
    let app = new App();
    let config = {
        headers: {
            // 默认值
            'Content-Type': 'application/json'
        }
    };
    axios.post(context + "app/save", app, config).then(res => {
        console.log(res.data)
    }).catch(err => {
        console.log(err);
    });

    // $.ajax({
    //     url: context + '/app/app/save',
    //     type: 'post',
    //     contentType: 'application/json',
    //     data: JSON.stringify(app),
    //     dataType: 'json',
    //     success: function (data) {
    //         console.log(data);
    //         top.layer.alert(data.msg);
    //     },
    //     error: function (data) {
    //         console.log("Error");
    //     }
    // });
}

/**
 * 所有必填的属性不能为空校验控制
 */
function verifyNull() {
    $('.required').each(function (index, ele) {
        let value = $(ele).val();
        if (!value) {
            let text = $(ele).parent().parent().find("label").text();
            layer.alert(text.substring(0, text.length - 1) + "不能为空");
            return false;
        }
    });
}

var stage;
var scene;

function initNodePosition() {
    let canvas = document.getElementById('canvas');
    stage = new JTopo.Stage(canvas);
    scene = new JTopo.Scene(stage);
    stage.add(scene);
    scene.alpha = 1;
    stage.mode = "edit";
    scene.backgroundColor = "237,240,243";
    let node = new JTopo.Node();    // 创建一个节点
    let nodeWidth = parseInt(WIDTH / 4);
    let nodeHeight = parseInt(HEIGHT / 4);
    node.setSize(nodeWidth, nodeHeight);
    node.fillColor = "129,130,132";
    node.setLocation(5, HEIGHT - 5 - nodeHeight);    // 设置节点坐标
    scene.add(node); // 放入到场景中
    node.mousedrag(function (event) {
        console.log(event);
        let position = node.getBound();
        position.left < 5 && node.setLocation(5, position.top);
        position.right > WIDTH - 5 && node.setLocation(WIDTH - 5 - position.width, position.top);
        position.top < 5 && node.setLocation(position.left, 5);
        position.bottom > HEIGHT - 5 && node.setLocation(position.left, HEIGHT - 5 - position.height);
        setPosition(node.getBound());
    });
    return node;
}

function setPosition(position) {
    $('#xPos').val(position.left);
    $('#yPos').val(position.top);
    $('#width').val(position.width);
    $('#height').val(position.height);
}

/**
 * 添加选项
 */
function addOption(thisEle) {
    let html = '<form class="form-horizontal">'
        + '<div class="form-group"><label class="col-sm-4 control-label" for="option_name_' + OPTION_ITEM_INDEX + '">选项名称<span style="color: red;">*</span></label>'
        + '<div class="col-sm-8"><input id="option_name_' + OPTION_ITEM_INDEX + '" class="form-control required"/></div></div>'
        + '<div class="form-group"><label class="col-sm-4 control-label" for="option_detail_' + OPTION_ITEM_INDEX + '">选项详情</label>'
        + '<div class="col-sm-8"><input id="option_detail_' + OPTION_ITEM_INDEX + '" class="form-control"/></div></div>'
        + '<div class="form-group"><label class="col-sm-4 control-label" for="option_pic_' + OPTION_ITEM_INDEX + '">选项图片</label>'
        + '<div class="col-sm-8"><input type="file" id="option_pic_' + OPTION_ITEM_INDEX + '" name="option_pic_' + OPTION_ITEM_INDEX + '" class="form-control"/></div></div>'
        + '<div class="form-group"><button class="btn btn-primary form-control" onclick="removeOption(this)">移除本选项</button></div>'
        + '</form>';
    $(thisEle).parent().before(html);
    initPicUpload("option_pic_" + OPTION_ITEM_INDEX);
    OPTION_ITEM_INDEX++;
}

/**
 * 移除选项
 * @param thisEle 移除按钮
 */
function removeOption(thisEle) {
    $(thisEle).parent().parent().remove();
    // 移除后是否需要减少OPTION_ITEM_INDEX
    // OPTION_ITEM_INDEX--;
}


/**
 * 根据元素id上传图片，并返回服务器图片访问地址
 * @param eleId 元素id
 * @returns {string} 图片地址
 */
function ajaxUpload(eleId, requestUrl) {
    let path = "";
    let file = document.getElementById(eleId).files[0];
    if (!file) {
        return "没有图片";
    }
    let fd = new FormData();
    requestUrl = requestUrl || (context + "/app/app/uploadPic");
    fd.append("backgroundUrl", file);
    $.ajax({
        url: requestUrl,
        type: 'post',
        data: fd,
        dataType: 'json',
        async: false,
        processData: false,
        contentType: false,
        success: function (data) {
            path = data.msg;
        }
    });

    return path;
}

/**
 * 根据元素ID初始化上传图片组件.
 *
 */
function initPicUpload(eleId, originalPath) {
    //获取实例id
    // let id = $("#id").val();
    //原图片预览html
    let previewHtml = "";
    let url = $('#' + eleId).data('value');
    if (url) {
        previewHtml = "<img src='" + ftpConfig + "/" + url + "' class='file-preview-image kv-preview-data' " +
            "style='width: auto; max-width: 90%; max-height: 90%;' alt='图片'>";
    }
    $("#" + eleId).fileinput({
        language: "zh", //设置语言
        uploadUrl: context + "/app/app/uploadPic",
        uploadAsync: false,
        showUpload: false, //是否显示上传按钮
        showRemove: true, //显示移除按钮
        showPreview: true, //是否显示预览
        previewFileType: ['image'],
        browseClass: "btn btn-primary btn-sm", //按钮样式
        dropZoneEnabled: false, //是否显示拖拽区域
        maxFileSize: 0, //单位为kb，如果为0表示不限制文件大小
        maxFileCount: 1, //表示允许同时上传的最大文件个数
        allowedFileExtensions: ["jpg", "png", "gif", "jpeg"], //允许上传的文件扩展名
        autoReplace: true, //是否自动替换已上传文件,
        layoutTemplates: {
            footer: "" //无底角信息
        },
        enctype: "multipart/form-data",
        initialPreview: previewHtml
    }).on("filecleared", function (event, data, msg) {
        picFileDeleted = true;
    });
    if (url) {
        $('.file-caption-name').append(url);
    }
}

/**
 * 应用时间相关构造器.
 */
function ScheduleInfo() {
    let playTime = $('#playTime').val();
    playTime = new Date(playTime).getTime();
    let chnlName = $('#chnlName').val();
    let stopTime = $('#stopTime').val();
    stopTime = new Date(stopTime).getTime();
    let postUrl = $('#postUrl').val();
    this.playTime = playTime;
    this.chnlName = chnlName;
    this.stopTime = stopTime;
    this.postUrl = postUrl;
    // this.anyUrl = anyUrl;
    this.anyUrl = "";
}

/**
 * 位置信息构造器
 * @param definition 清晰度，分为sd,hd,uhd
 * @constructor
 */
function PosSize(definition) {
    switch (definition) {
        case "sd":
            getPosSize(720, 576, this);
            break;
        case "uhd":
            getPosSize(3840, 2160, this);
            break;
        default:
            getPosSize(1920, 1080, this);
    }
}

function getPosSize(deviceWidth, deviceHeight, ele) {
    let bound = NODE.getBound();
    ele.width = Math.round(bound.width * deviceWidth / WIDTH);
    ele.height = Math.round(bound.height * deviceHeight / HEIGHT);
    ele.xPos = Math.round(bound.left * deviceWidth / WIDTH);
    ele.yPos = Math.round(bound.top * deviceHeight / HEIGHT);
}

/**
 * 观点构造器
 * @param index 观点排序，从0开始
 * @param element 观点的form表单
 * @constructor
 */
function Topic(index, element) {
    let inputs = $(element).find("input");
    this.opinion = $(inputs[0]).val();
    this.id = index;
    this.filename = ajaxUpload($(inputs[2]).attr("id"));
    this.detail = $(inputs[1]).val();
}

function Topics() {
    this.labelText = $('#labelText').val();
    this.paragraphText = $('#paragraphText').val();
    this.voteBtnText = $('#voteBtnText').val();
    this.opinions = [];
    let forms = $('#topic_options form');
    for (let i = 0; i < forms.length; i++) {
        this.opinions.push(new Topic(i, forms[i]));
    }
}

function App() {
    this.appName = $('#appName').val();
    this.appVersion = $('#appVersion').val();
    this.status = "submit";
    this.hdPosSize = new PosSize("hd");
    this.sdPosSize = new PosSize("sd");
    this.uhdPosSize = new PosSize("uhd");
    this.topics = new Topics();
    this.opacity = parseFloat($('#opacity').val());
    console.log($('#is_forced').val());
    this.is_forced = $('#is_forced').val() == '1';
    this.scheduleInfo = new ScheduleInfo();
}

function SelectTree(conf) {
    this.treeObj;
    this.srcData;
    this.config = {
        callback: {
            onDblClick: conf.callback
        },
        data: {
            simpleData: {
                enable: true,
                idKey: conf.id,
                pIdKey: conf.parentId,
                rootPId: -1
            },
            key: {
                url:"nourl",
                name: conf.name
            }
        }
    };
    this.param = conf.param;
    this.url = conf.url;
    this.treeId = conf.treeId;
    this.init();
};
SelectTree.prototype.init = function () {
    var _this = this;
    var ajaxParam = {
        type: "POST",
        url: _this.url,
        contentType: "application/json"
    };
    if (_this.param) {
        ajaxParam.data = JSON.stringify(_this.param);
    }
    ajaxParam.success = function(r){
        if(r.code == $util.HTTP_STATUS.SC_OK){
            _this.srcData = $.extend({}, r.data);
            _this.treeObj = $.fn.zTree.init($("#" + _this.treeId), _this.config, r.data);
        }else{
            alert(r.msg);
        }
    };
    $.ajax(ajaxParam);
};
SelectTree.prototype. getSelectedNodes = function () {
    return this.treeObj.getSelectedNodes();
}
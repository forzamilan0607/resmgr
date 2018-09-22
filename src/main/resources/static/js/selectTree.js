function TreeSelector(conf) {
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
TreeSelector.prototype.init = function () {
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
TreeSelector.prototype. getSelectedNodes = function () {
    return this.treeObj.getSelectedNodes();
}
TreeSelector.prototype.getHierarchyName = function (param) {
    var treeNodes = this.treeObj.getNodesByParam("id", param.id + "", null);
    var hierarchyNames = [(treeNodes && treeNodes.length) ? treeNodes[0][param.name] : ""];
    if (treeNodes && treeNodes[0][param.key]) {
        hierarchyNames.push(this.getHierarchyName({
            id: treeNodes[0][param.key],
            name: param.name,
            key: param.key
        }));
    }
    return hierarchyNames.reverse().join("\\");
}
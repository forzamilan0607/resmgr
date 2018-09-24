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
    this.url = conf.data;
    this.treeId = conf.treeId;
    this.init();
};
TreeSelector.prototype.init = function () {
    var _this = this;
    if (!_this.url && _this.data) {
        _this.srcData = $.extend({}, _this.data);
        _this.treeObj = $.fn.zTree.init($("#" + _this.treeId), _this.config, _this.data);
    } else {
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
    }
};
TreeSelector.prototype. getSelectedNodes = function () {
    return this.treeObj.getSelectedNodes();
}
TreeSelector.prototype.getHierarchyName = function (param) {
    var _this = this;
    function _getHierarchyName (param) {
        var treeNodes = _this.treeObj.getNodesByParam("id", param.id + "", null);
        var hierarchyName = (treeNodes && treeNodes.length) ? treeNodes[0][param.name] : "";
        if (treeNodes && treeNodes.length && treeNodes[0][param.key]) {
            hierarchyName += _getHierarchyName({
                id: treeNodes[0][param.key] + "",
                name: param.name,
                key: param.key
            });
        }
        return "," + hierarchyName;
    }
    var hierarchyName = _getHierarchyName(param);
    if (hierarchyName && hierarchyName[0] == ',' && hierarchyName[hierarchyName.length - 1] == ',') {
        return hierarchyName.substring(1, hierarchyName.length - 1).split(",").reverse().join("\\");
    }
    return "";
}
TreeSelector.prototype.getData = function () {
    return (this.srcData && this.srcData.length) ? $.merge([], this.srcData) : [];
}
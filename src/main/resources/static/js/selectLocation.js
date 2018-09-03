var $locationTree = function () {
    var _treeObj, _srcData;
    var _config = {
        data: {
            simpleData: {
                enable: true,
                idKey: "id",
                pIdKey: "parentLocationId",
                rootPId: -1
            },
            key: {
                url:"nourl",
                name: "name"
            }
        }
    };
    return {
        init: function (treeId) {
            $.ajax({
                type: "POST",
                url: "/resmgr/res/location/queryLocationListByCondition",
                contentType: "application/json",
                data: JSON.stringify({}),
                success: function(r){
                    if(r.code == $util.HTTP_STATUS.SC_OK){
                        _srcData = $.extend({}, r.data);
                        _treeObj = $.fn.zTree.init($("#" + treeId), _config, r.data);
                    }else{
                        alert(r.msg);
                    }
                    // var node = ztree.getNodeByParam("dictId", parentId).getNodeByParam("dictId", parentId);
                    // this.treeObj.selectNode(node);
                }
            });
            // vm.menu.parentName = node.name;
        },
        getSelectedNodes: function () {
            return _treeObj.getSelectedNodes();
        }
    }
}();
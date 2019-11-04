App.createStore = function () {


    Ext.define('orderVoModel', {
        extend: 'Ext.data.Model',
        fields: [{
            name: 'lookupCodeId',
            type: 'int'
        }, {
            name: 'lookupType',
            type: 'string'
        }, {
            name: 'lookupCode',
            type: 'string'
        }, {
            name: 'lookupValue',
            type: 'string'
        }, {
            name: 'attribute1',
            type: 'string'
        }, {
            name: 'attribute2',
            type: 'string'
        }, {
            name: 'attribute3',
            type: 'string'
        }, {
            name: 'attribute4',
            type: 'string'
        }, {
            name: 'orderNumber',
            type: 'int'
        }, {
            name: 'creationDate'
        }, {
            name: 'createdBy'
        }, {
            name: 'lastUpdateDate'
        }, {
            name: 'lastUpdatedBy'
        }, {
            name: 'disableFlag',
            type: 'string'
        }, {
            name: 'disableDate'
        }]
    });


    App.resultStore =  Ext.create('Ext.data.Store', {
        pageSize : 10,
        model : 'orderVoModel',
        proxy : {
            type : 'ajax',
            url : '',
            timeout : 300000,
            reader : {
                type : 'json',
                root : 'rows',
                totalProperty : 'totalRecords'
            },
            extraParams : {
                testResultId : localTexts.result.testResultId
            }
        },
        actionMethods : {
            read : 'POST'
        },
        listeners : {
            scope : this,
            //loadexception : LMSResult.testResultStoreException
        }
    });

}
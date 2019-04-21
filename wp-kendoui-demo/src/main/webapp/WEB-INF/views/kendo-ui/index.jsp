<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="/WEB-INF/includes/commonHeadTags.jsp"%>
<title>Welcome to Resource Calculator</title>
<style type="text/css">
.k-grid td{
  white-space: nowrap;
}
</style>
</head>
<body>
<wp:wp-layout-default>
<h4>Testing Kendo</h4>

<div id="example">
    <div id="grid"></div>
    <script>
        $(document).ready(function () {
        
        	/*
        	$("#gridxxx").kendoGrid({
                dataSource: {
                    datatype: "json",
                    transport: {
                        read: "http://localhost:7001/kdemo/api/loadforecast/get-loadforecasts"
                    },
                    pageSize: 20,
                    schema: {
                        model: {
                        	fields: {
                                id: { type: "number" },
                                title: { type: "string" },
                                description: { type: "string" },
                                comment: { type: "string" }
                            }
                        }
                    },

                    aggregate: [ { field: "loadForecast.id", aggregate: "count" },
                                  { field: "loadForecast.title", aggregate: "count" },
                                  { field: "loadForecast.description", aggregate: "count" },
                                  { field: "loadForecast.comment", aggregate: "count" }]
                },
                
                
                filterable: {
                    mode: "row"
                },

                groupable: true,
                sortable: true,
                pageable: {
                    refresh: true,
                    pageSizes: true,
                    buttonCount: 5
                },
                editable: true,
                columns: [
                	
                	{ 
                		command: { 
                			text: "Fill", 
                			click: fillall 
                			}, 
                			title: " ", width: "180px" 
                	},
                	{                   
                    field: "loadForecast.id",
                    title: "ID decorator",
                    width: 240,
                    aggregates: ["count"], 
                    footerTemplate: "Total Count: #=count#", 
                    groupFooterTemplate: "Count: #=count#"
                }, {
                    field: "loadForecast.title",
                    title: "Title"
                }, {
                    field: "loadForecast.description",
                    title: "Description"
                }, {
                    field: "loadForecast.comment",
                    title: "Comment",
                    width: 150
                }]
            });
        	*/
        	
        	 /************************************************************************/
            
            var columns = [];
        	var aggregates=[{ field: "loadForecast.id", aggregate: "count" }];

         columns.push({ 
        		command: { 
        			text: "Fill", 
        			click: fillall 
        			}, 
        			title: " ", width: "180px" 
        	});
            
        columns.push({                   
            field: "loadForecast.id",
            title: "ID",
            width: 70,
            aggregates: ["count"], 
            footerTemplate: "Total Count: #=count#", 
            groupFooterTemplate: "Count: #=count#"
        });
        columns.push({
            field: "loadForecast.title",
            title: "Title",
            width: 240
        });
        columns.push({
            field: "loadForecast.description",
            title: "Description",
            width: 240,
            filterable: {
                cell: {
                    operator: "contains",
                    suggestionOperator: "contains"
                }
            }
        });
        columns.push({
            field: "loadForecast.comment",
            title: "Comment",
            width: "240px"
        });   
        
        
        /*
        * add the column array
        **/
            for (var i = 0; i < 24; i++) {
                var entryIndex = "hourlyAverage[" + i + "]";
                var HE=i+1;
                columns.push({
                    field: entryIndex,
                    title: "HE " + HE,

                    aggregates: ["sum"], 
                    footerTemplate: "#=sum#", 
                    groupFooterTemplate: "Sum: #=sum#"
                });
                aggregates.push({ field: entryIndex, aggregate: "sum"});
            }

            var configuration = {
            		 dataSource: {
                         datatype: "json",
                         transport: {
                             read: "http://localhost:7001/kdemo/api/loadforecast/get-loadforecasts"
                         },
                         pageSize: 5,
                         schema: {
                             model: {
                             	fields: {
                                     id: { type: "number" },
                                     title: { type: "string" },
                                     description: { type: "string" },
                                     comment: { type: "string" },
                                     hourlyAverage:[{type: "number"}]
                                 }
                             }
                         },

                         aggregate: aggregates
                     },
                     
                     sortable: true,
                     pageable: {
                         refresh: true,
                         pageSizes: true,
                         buttonCount: 5
                     },
                editable: true,
                sortable: true,
                scrollable: false,
                columns: columns
            };
        	
        	
        	$("#grid").kendoGrid(configuration).data("kendoGrid");
        });
      
        
       
        
        
        
        function fillall(e) {
            e.preventDefault();

            var dataItem = this.dataItem($(e.currentTarget).closest("tr"));
            dataItem.set("loadForecast.title", "sdfsdlfsdfsdfsdfsdf");
            console.log(dataItem);
        	
        }
    </script>
</div>

</wp:wp-layout-default>
</body>
</html>
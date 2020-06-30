$(document).ready(function() {
    getRequest("/item/getDailySales",
        function (res) {
            var dataset = res.content;
            var tableLabels = dataset.map(function (item) {
                return item.date;
            })
            var tableData = dataset.map(function (item) {
                return item.num;
            })
            var ctx = document.getElementById("itemDailySales");
            var myChart = new Chart(ctx, {
                type: 'line',
                data: {
                    labels: tableLabels,
                    datasets: [{
                        label: '商品销量',
                        data: tableData,
                        backgroundColor: window.chartColors.red,
                        borderColor: window.chartColors.red,
                        fill: false
                    }]
                },
                options: {
                    responsive: true,
                    title: {
                        display: true,
                        text: '商品日销表'
                    },
                    hover: {
                        mode: 'nearest',
                        intersect: true
                    },
                    scales: {
                        xAxes: [{
                            display: true,
                            scaleLabel: {
                                display: true,
                                labelString: '日期'
                            }
                        }],
                        yAxes: [{
                            display: true,
                            scaleLabel: {
                                display: true,
                                labelString: '销量'
                            }
                        }]
                    }
                }
            });
        })
    getRequest("/item/getWeeklySales",
        function (res) {
            var dataset = res.content;
            var tableLabels = dataset.map(function (item) {
                return item.beginDate + " ~ " + item.endDate;
            })
            var tableData = dataset.map(function (item) {
                return item.num;
            })
            var ctx = document.getElementById("itemWeeklySales");
            var myChart = new Chart(ctx, {
                type: 'line',
                data: {
                    labels: tableLabels,
                    datasets: [{
                        label: '商品销量',
                        data: tableData,
                        backgroundColor: window.chartColors.blue,
                        borderColor: window.chartColors.blue,
                        fill: false
                    }]
                },
                options: {
                    responsive: true,
                    title: {
                        display: true,
                        text: '商品周销表'
                    },
                    hover: {
                        mode: 'nearest',
                        intersect: true
                    },
                    scales: {
                        xAxes: [{
                            display: true,
                            scaleLabel: {
                                display: true,
                                labelString: '日期'
                            }
                        }],
                        yAxes: [{
                            display: true,
                            scaleLabel: {
                                display: true,
                                labelString: '销量'
                            }
                        }]
                    }
                }
            });
        })
})

$(document).ready(function() {

    getRequest("/restaurant/getDailySales",
        function (res) {
            var dataset = res.content;
            var ctx = document.getElementById("restaurantDailySales");
            var num = Object.values(dataset);
            alert(num.length);
            var sum = [];
            for (i = 0; i < num.length; i++){
                var num2 = Object.values(num[i]);

                var summary = 0;
                for(j = 0; j < num2.length; j++){
                    summary += num2[j].num;
                }
                sum.push(summary);
            }
            console.log(sum);
            var myChart = new Chart(ctx, {
                type: 'line',
                data: {
                    labels: Object.keys(dataset),
                    datasets: [{
                        label: '商家销量',
                        data: sum,
                        backgroundColor: window.chartColors.red,
                        borderColor: window.chartColors.blue,
                        fill: false
                    }]
                },
                options: {
                    responsive: true,
                    title: {
                        display: true,
                        text: '商家日销表'
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
    // getRequest("/restaurant/getWeeklySales",
    //     function (res) {
    //         var dataset = res.content;
    //         var ctx = document.getElementById("restaurantWeeklySales");
    //         var myChart = new Chart(ctx, {
    //             type: 'line',
    //             data: {
    //                 labels: tableLabels,
    //                 datasets: [{
    //                     label: '商家销量',
    //                     data: tableData,
    //                     backgroundColor: window.chartColors.blue,
    //                     borderColor: window.chartColors.blue,
    //                     fill: false
    //                 }]
    //             },
    //             options: {
    //                 responsive: true,
    //                 title: {
    //                     display: true,
    //                     text: '商家周销表'
    //                 },
    //                 hover: {
    //                     mode: 'nearest',
    //                     intersect: true
    //                 },
    //                 scales: {
    //                     xAxes: [{
    //                         display: true,
    //                         scaleLabel: {
    //                             display: true,
    //                             labelString: '日期'
    //                         }
    //                     }],
    //                     yAxes: [{
    //                         display: true,
    //                         scaleLabel: {
    //                             display: true,
    //                             labelString: '销量'
    //                         }
    //                     }]
    //                 }
    //             }
    //         });
    //     })
})

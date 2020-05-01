option = {
    tooltip : {
        trigger: 'axis'
    },
    legend: {
        data:['cmq-HttpClient','mofa-HttpClient']
    },
    toolbox: {
        show : true,
        feature : {
            mark : {show: true},
            dataView : {show: true, readOnly: false},
            magicType : {show: true, type: ['line', 'bar', 'stack', 'tiled']},
            restore : {show: true},
            saveAsImage : {show: true}
        }
    },
    calculable : true,
    xAxis : [
        {
            type : 'category',
            boundaryGap : false,
            data : ['1','2','3','4','5','6','7','8','9','10','11','12','13','14','15','16','17','18','19','20','21','22','23','24','25','26','27','28','29','30','31','32','33','34','35','36','37','38','39','40','41','42','43','44','45','46','47','48','49','50']
        }
    ],
    yAxis : [
        {
            type : 'value'
        }
    ],
    series : [
        {
            name:'cmq-HttpClient',
            type:'line',
            stack: '总量',
            data:[1586, 493, 429, 499, 504, 522, 478, 451, 496, 421, 498, 514, 510, 514, 510, 514, 483, 459, 419, 583, 554, 465, 513, 613, 515, 612, 512, 512, 513, 465, 561, 476, 446, 507, 513, 515, 511, 510, 513, 511, 512, 440, 584, 442, 453, 539, 512, 512, 512, 510]
        },
        {
            name:'mofa-HttpClient',
            type:'line',
            stack: '总量',
            data:[1230, 475, 550, 510, 451, 463, 420, 449, 573, 521, 504, 404, 440, 586, 451, 417, 479, 497, 512, 452, 469, 441, 586, 492, 532, 480, 544, 452, 570, 482, 541, 466, 559, 458, 566, 512, 513, 510, 520, 607, 516, 507, 513, 513, 511, 512, 476, 449, 631, 467]
        }
    ]
};


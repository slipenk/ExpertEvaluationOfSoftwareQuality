var data = [
    {
        type: "scatterpolar",
        name: "angular categories",
        r: [5, 4, 2, 4, 5],
        theta: ["a", "b", "c", "d", "a"],
        fill: "toself"
    },
    {
        type: "scatterpolar",
        name: "radial categories",
        r: ["a", "b", "c", "d", "b", "f", "a"],
        theta: [1, 4, 2, 1.5, 1.5, 6, 5],
        thetaunit: "radians",
        fill: "toself",
        subplot: "polar2"
    },
    {
        type: "scatterpolar",
        name: "angular categories (w/ categoryarray)",
        r: [5, 4, 2, 4, 5],
        theta: ["a", "b", "c", "d", "a"],
        fill: "toself",
        subplot: "polar3"
    },
    {
        type: "scatterpolar",
        name: "radial categories (w/ category descending)",
        r: ["a", "b", "c", "d", "b", "f", "a", "a"],
        theta: [45, 90, 180, 200, 300, 15, 20, 45],
        fill: "toself",
        subplot: "polar4"
    },
    {
        type: "scatterpolar",
        name: "angular categories (w/ extra category)",
        r: [5, 4, 2, 4, 5, 5],
        theta: ["b", "c", "d", "e", "a", "b"],
        fill: "toself"
    }
]

var layout = {
    polar: {
        domain: {
            x: [0, 0.46],
            y: [0.56, 1]
        },
        radialaxis: {
            angle: 45
        },
        angularaxis: {
            direction: "clockwise",
            period: 6
        }
    },
    polar2: {
        domain: {
            x: [0, 0.46],
            y: [0, 0.44]
        },
        radialaxis: {
            angle: 180,
            tickangle: -180
        }
    },
    polar3: {
        domain: {
            x: [0.54, 1],
            y: [0.56, 1]
        },
        sector: [150, 400],
        radialaxis: {
            angle: -45
        },
        angularaxis: {
            categoryarray: ["d", "a", "c", "b"]
        }
    },
    polar4: {
        domain: {
            x: [0.54, 1],
            y: [0, 0.44]
        },
        radialaxis: {
            categoryorder: "category descending"
        },
        angularaxis: {
            thetaunit: "radians",
            dtick: 0.3141592653589793
        }
    }
}

Plotly.newPlot('myDiv', data, layout)

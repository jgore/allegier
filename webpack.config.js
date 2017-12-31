module.exports = {

    entry: "./src/main/webapp/WEB-INF/resources/app.js",

    output: {
        filename: "./src/main/webapp/WEB-INF/resources/bundle.js"
    },
    module: {
        loaders: [
            {
                test: /\.js$/,
                exclude: /node_modules/,
                loader: 'babel-loader',
                query: {
                    cacheDirectory: true,
                    presets: ['es2015', 'react']
                }

            }
        ]
    }
};
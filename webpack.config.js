const os = require('os');
const path = require('path');
const webpackMerge = require('webpack-merge');
const HappyPack = require('happypack');
const commonConfig = require('./webpack.config.common');
const MiniCssExtractPlugin = require('mini-css-extract-plugin');
const happyPackThreadPool = HappyPack.ThreadPool({ size: os.cpus().length });

module.exports = webpackMerge(commonConfig, {
    mode: 'development',
    devtool: 'cheap-module-source-map',
    output: {
        filename: '[name].js',
        path: path.resolve(__dirname, 'deploy/static/bundle'),
    },
    module: {
        rules: [
            {
                test: /\.(le|c)ss$/,
                use: [MiniCssExtractPlugin.loader, 'happypack/loader?id=style'],
            },
            {
                test: /\.js$/,
                exclude: /node_modules|src\/main\/webapp\/static\/vendor/,
                use: 'happypack/loader?id=js',
            },
        ],
    },
    plugins: [
        new MiniCssExtractPlugin({ filename: '[name].css' }),
        new HappyPack({
            id: 'js',
            threadPool: happyPackThreadPool,
            loaders: ['babel-loader'],
        }),
        new HappyPack({
            id: 'style',
            threadPool: happyPackThreadPool,
            loaders: ['css-loader'],
        }),
    ],
});
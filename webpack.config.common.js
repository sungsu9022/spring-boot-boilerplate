const path = require('path');
const fs = require('fs-extra');
const VueLoaderPlugin = require('vue-loader/lib/plugin');

const srcdir = path.resolve(__dirname, 'src/main/webapp');
const exclusivePattern = /sw[pon]$/

const entries = makeEntries({
    vendor: [
        'babel-polyfill',
        require.resolve('vue')
    ],
});

module.exports = {
    entry: entries,
    output: {
        filename: '[name].js',
        publicPath: '/static/bundle/',
    },
    resolve: {
        alias: {
            vue: 'vue/dist/vue.js'
        }
    },
    module: {
        rules: [
            {
                test: /\.js$/,
                exclude: /node_modules|src\/main\/webapp\/static\/vendor/,
                use: 'babel-loader',
            },
            {
                test: /\.vue$/,
                use: "vue-loader",
            },
        ]
    },
    optimization: {
        splitChunks: {
            cacheGroups: {
                default: false,
                vendors: false,
                vendor: {
                    name: 'vendor',
                    test: 'vendor',
                    enforce: true,
                },
            },
        },
    },
    plugins: [
        new VueLoaderPlugin(),
    ]
};



function makeEntries(additionalEntry) {
    const entries = {};
    const entryDir = path.join(srcdir, '/static/js/entry');

    extractEntry(entryDir);

    return Object.assign(entries, additionalEntry);

    // entries에 ./static/entry 폴더를 순회해서 나온 relativePath를 넣어준다.
    function extractEntry(absolutePath, relativePath) {
        if (fs.lstatSync(absolutePath).isDirectory()) {
            fs.readdirSync(absolutePath).forEach(function (file) {
                const currentRelativePath = relativePath ? `${relativePath}/${file}` : file;
                if (exclusivePattern.test(currentRelativePath))
                    return;
                extractEntry(path.join(absolutePath, file), currentRelativePath);
            });
            return;
        }

        var id = relativePath.substr(0, relativePath.lastIndexOf('.')) || relativePath;
        entries[id] = absolutePath;
    }
}

import React from 'react';
import Loadable from 'react-loadable';

/**
 * 加载中页面（未做样式处理，空白页）
 * @param loader
 * @returns {*}
 */
export default (loader) => {
    return Loadable({
        loader,
        loading() {
            return <div></div>
        },
    });
}

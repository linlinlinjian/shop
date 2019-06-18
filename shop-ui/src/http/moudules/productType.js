import axios from '../axios'

/* 
 * 商品分类管理新增模块
 */

// 保存
export const save = (data) => {
    return axios({
        url: '/pmsProductCategory/insertPmsProductCategory',
        method: 'post',
        data
    })
}

//删除
export const deletes = (data) => {
    return axios({
        url: '/pmsProductCategory/deletePmsProductCategory',
        method: 'post',
        data
    })
}
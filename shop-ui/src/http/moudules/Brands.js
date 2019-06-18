import axios from '../axios'

// 保存
export const save = (data) => {
    return axios({
        url: '/pmsBrand/insertPmsBrand',
        method: 'post',
        data
    })
}

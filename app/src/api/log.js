import request from '@/utils/request'

export function getList(data, query) {
  return request({
    url: `/api/log/list`,
    method: 'get',
    params:{
      page: query.page,
      limit: query.limit,
      username: data.username,
      ip: data.ip
    }
  })
}

export function del(id) {
  return request({
    url: `/api/log/${id}`,
    method: 'delete'
  })
}

export function visitSum(time) {
  return request({
    url: `/api/log/visitCount`,
    method: 'get',
    params: {
      time: time
    }
  })
}

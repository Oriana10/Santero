import axios from 'axios';

const baseUrl = 'http://localhost:8080/';

export const httpGet = async (endpoint) => {
  return axios.get(baseUrl + endpoint);
};

export const httpGetAuthorization = async (endpoint) => {
  return axios.get(baseUrl + endpoint, {
    headers: {
      authorization: 'Bearer ' + localStorage.getItem('token'),
    },
  });
};

export const httpPostAuthorization = async (endpoint, data) => {
  return axios.post(baseUrl + endpoint, data, {
    headers: {
      authorization: 'Bearer ' + localStorage.getItem('token'),
    },
  });
};

export const httpPost = async (endpoint, data) => {
  return axios.post(baseUrl + endpoint, data);
};

export const httpDelete = async (endpoint) => {
  return axios.delete(baseUrl + endpoint, {
    headers: {
      authorization: 'Bearer ' + localStorage.getItem('token'),
    },
  });
};

export const httpPutAuthorization = async (endpoint, data) => {
  return axios.put(baseUrl + endpoint, data, {
    headers: {
      authorization: 'Bearer ' + localStorage.getItem('token'),
    },
  });
};
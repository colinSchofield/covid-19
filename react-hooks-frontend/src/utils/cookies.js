import Cookies from 'universal-cookie'

const cookies = new Cookies()
const COOKIE_KEY = "covid-19-userId"

export const setCookie = (value) => {
  cookies.set(COOKIE_KEY, value, { path: '/', maxAge: Number.MAX_SAFE_INTEGER })
}

export const getCookie = () => {
  return cookies.get(COOKIE_KEY)
}

export const clearCookie = () => {
  cookies.set(COOKIE_KEY, null, { path: '/' })
}
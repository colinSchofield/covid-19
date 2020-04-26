const setupHeaders = () => {

  const username = "admin"
  const password = "admin"
  let headers = new Headers();
  headers.append("Authorization", "Basic " + btoa(username + ":" + password));
  return headers
}

export const getCovid19Stats = () => {

  const url = "/api/1.0/list/covid19"

  return fetch(url, { method: "GET", headers: setupHeaders() })
    .then(response => {
      if (response.ok) {
        return response.json()
      } else {
        console.error("Network Error", response)
        throw new Error("Network Error, please wait a while and try again: " + response.statusText)
      }
    })
    .catch((error) => {
      console.error("Network Error", error)
      throw error
    })
}

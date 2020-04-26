import React from 'react'

export default function App({stats}) {

  return (
      <table>
        <thead>
          <tr>
            <th>Country</th>
          </tr>
        </thead>
        <tbody>
        { stats.map(({ country })=> (
          <tr key={country}>
            <td>{country}</td>
          </tr>
          ))}
        </tbody>
      </table>
    )
}
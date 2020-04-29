import React from 'react'
import { Button, Form, FormControl } from 'react-bootstrap'

export default function TableSearch({tableData, filterTable}) {
  const [ search, setSearch ] = React.useState("")
  const fullTable = React.useRef(null)
  const searchFieldRef = React.useRef()

  React.useEffect(() => {

    if (fullTable.current === null && tableData !== null) {
      fullTable.current = tableData
      searchFieldRef.current.focus()
    }

  }, [ tableData ])

  function updateSearch(event) {

    setSearch(event.target.value)
    const results = fullTable.current.filter((element) =>
        element.country.toLowerCase().startsWith(event.target.value.toLowerCase()))
    filterTable(results)
  }

  return (

    <Form inline>
      <FormControl type="text"
        placeholder="Country Name" className="mr-sm-2"
        value={search} onChange={updateSearch} ref={searchFieldRef} />
      <Button variant="outline-success">Search</Button>
    </Form>
  )
}
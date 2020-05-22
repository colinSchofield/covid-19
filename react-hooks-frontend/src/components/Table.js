import React from 'react'
import BootstrapTable from 'react-bootstrap-table-next'
import paginationFactory from 'react-bootstrap-table2-paginator'
import TableDetails from './TableDetails'
import { useWindowDimensions, detectMobileChange } from '../utils/mobileResponsive'

export default function App({data, displayRegion}) {
  const { width } = useWindowDimensions()
  const [columns, setColumns] = React.useState(detectMobileChange())
  const [detailsView, setDetailsView] = React.useState(false)
  const [region, setRegion] = React.useState("")

  const defaultSorted = [
    {
      dataField: 'deaths.total',
      order: 'desc'
    }
  ]

  const selectRow = {
    mode: 'radio',
    hideSelectColumn: true,
    clickToSelect: true,
    onSelect: (row, isSelect, rowIndex, e) => {
      if (region === row.country) {
        setRegion(row.country + " ")
      } else {
        setRegion(row.country)
      }
      setDetailsView(true)
    }
  }

  React.useEffect(() => {
    setColumns(detectMobileChange())
  }, [width])

  React.useEffect(() => {
    if (displayRegion !== null) {
      setRegion(displayRegion)
      setDetailsView(true)
    }
  }, [displayRegion])

  return (

      <>
        <BootstrapTable
            selectRow={ selectRow }
            bootstrap4
            keyField="country"
            data={ data }
            columns={ columns }
            defaultSorted={ defaultSorted }
            pagination={ paginationFactory() }
            striped
            hover
            condensed
        />
        { detailsView && <TableDetails region={region} /> }
      </>
    )
}
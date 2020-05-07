import React from 'react'
import BootstrapTable from 'react-bootstrap-table-next'
import paginationFactory from 'react-bootstrap-table2-paginator'
import TableDetails from './TableDetails'
import { detectMobile } from '../utils/mobile'

export default function App({stats}) {
  const [columns, setColumns] = React.useState(detectMobile())
  const [detailsView, setDetailsView] = React.useState(false)
  const [region, setRegion] = React.useState("")

  const defaultSorted = [
    {
      dataField: 'deaths.total',
      order: 'desc'
    }
  ];

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

  return (

      <div>
        <BootstrapTable
            selectRow={ selectRow }
            bootstrap4
            keyField="country"
            data={ stats }
            columns={ columns }
            defaultSorted={ defaultSorted }
            pagination={ paginationFactory() }
            striped
            hover
        />
        { detailsView && <TableDetails region={region} date={new Date().getTime()} /> }
      </div>
    )
}
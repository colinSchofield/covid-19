export const detectMobile = () => {
    return (false) ? columnsMobile : columnsDesktop
}

  const columnsMobile = [
    {
      dataField: 'country',
      text: 'Country',
      sort: true
    },
    {
      dataField: 'cases.total',
      text: 'Total Cases',
      sort: true
    },
    {
      dataField: 'cases.new',
      text: 'New Cases',
      sort: true
    },
    {
      dataField: 'deaths.total',
      text: 'Total Deaths',
      sort: true
    },
    {
      dataField: 'deaths.new',
      text: 'New Deaths',
      sort: true
    }
  ]

  const columnsDesktop = [
    {
      dataField: 'country',
      text: 'Country',
      sort: true
    },
    {
      dataField: 'cases.total',
      text: 'Total Cases',
      sort: true
    },
    {
      dataField: 'cases.new',
      text: 'New Cases',
      sort: true
    },
    {
      dataField: 'deaths.total',
      text: 'Total Deaths',
      sort: true
    },
    {
      dataField: 'deaths.new',
      text: 'New Deaths',
      sort: true
    },
    {
      dataField: 'cases.recovered',
      text: 'Total Recovered',
      sort: true
    },
    {
      dataField: 'cases.active',
      text: 'Active Cases',
      sort: true
    },
    {
      dataField: 'cases.critical',
      text: 'Serious, Critical',
      sort: true
    },
    {
      dataField: 'tests.total',
      text: 'Total Tests',
      sort: true
    }
  ]
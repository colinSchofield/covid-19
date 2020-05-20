import React from 'react'
import List from '@material-ui/core/List'
import ListItem from '@material-ui/core/ListItem'
import Checkbox from '@material-ui/core/Checkbox'
import { getRegions } from '../../utils/api'
import { Spinner } from 'react-bootstrap'


export default function RegionList({checked, setChecked}) {
  const [regionData, setRegionData] = React.useState(null)

  React.useEffect(() => {
    getRegions()
      .then((regions) => {
        setRegionData(regions)
      })
      .catch((exception) => {
        console.log("Error was Caught!", exception)
      })
  }, [])

  const handleToggle = (key) => () => {
    const currentIndex = checked.indexOf(key)
    const newChecked = [...checked]

    if (currentIndex === -1) {
      newChecked.push(key)
    } else {
      newChecked.splice(currentIndex, 1)
    }

    setChecked(newChecked)
  }

  return (
    <List dense>
      { !regionData && <Spinner animation="border" variant="success" /> }
      { regionData && regionData.map((element) => {
        const key = element.key
        return (
          <ListItem onClick={handleToggle(key)} key={key} button>
            <Checkbox
              edge="end"
              onChange={handleToggle(key)}
              checked={checked.indexOf(key) !== -1}
              inputProps={{ 'aria-labelledby': key }}
            />
            &nbsp;&nbsp;&nbsp;&nbsp;<h1>{element.flag}</h1>&nbsp;&nbsp;&nbsp;&nbsp;<h5>{element.location}</h5>
          </ListItem>
        )
      })}
    </List>
  )
}
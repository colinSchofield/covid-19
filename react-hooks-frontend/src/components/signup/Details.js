import React from 'react'
import { MDBCard, MDBCardBody, MDBCardTitle, MDBCardText, MDBRow, MDBCol, MDBInput } from 'mdbreact'
import ToggleButton from '@material-ui/lab/ToggleButton'
import ToggleButtonGroup from '@material-ui/lab/ToggleButtonGroup'
import { FaMale, FaFemale, FaVenusMars, FaBlind, FaBabyCarriage } from 'react-icons/fa'
import Grid from '@material-ui/core/Grid'
import Slider from '@material-ui/core/Slider'
import Image from 'react-bootstrap/Image'
import Female1Img from '../../assets/images/signup/female-1.jpg'
import Female2Img from '../../assets/images/signup/female-2.jpg'
import Female3Img from '../../assets/images/signup/female-3.jpg'
import Female4Img from '../../assets/images/signup/female-4.jpg'
import Female5Img from '../../assets/images/signup/female-5.jpg'
import Female6Img from '../../assets/images/signup/female-6.jpg'
import Female7Img from '../../assets/images/signup/female-7.jpg'
import Female8Img from '../../assets/images/signup/female-8.jpg'
import Female9Img from '../../assets/images/signup/female-9.jpg'
import Female10Img from '../../assets/images/signup/female-10.jpg'
import Female11Img from '../../assets/images/signup/female-11.jpg'
import Female12Img from '../../assets/images/signup/female-12.jpg'
import Male1Img from '../../assets/images/signup/male-1.jpg'
import Male2Img from '../../assets/images/signup/male-2.jpg'
import Male3Img from '../../assets/images/signup/male-3.jpg'
import Male4Img from '../../assets/images/signup/male-4.jpg'
import Male5Img from '../../assets/images/signup/male-5.jpg'
import Male6Img from '../../assets/images/signup/male-6.jpg'
import Male7Img from '../../assets/images/signup/male-7.jpg'
import Male8Img from '../../assets/images/signup/male-8.jpg'
import Male9Img from '../../assets/images/signup/male-9.jpg'
import Male10Img from '../../assets/images/signup/male-10.jpg'
import Male11Img from '../../assets/images/signup/male-11.jpg'

export default function Welcome({signupDetails}) {
  const [gender, setGender] = React.useState('Male')

  const handleGender = (event, newGender) => {
    if (newGender !== null) {
      setGender(newGender)
    }
  }

  const [value, setValue] = React.useState(7);

  const handleChange = (event, newValue) => {
    setValue(newValue);
  };

  return (
    <div>
      <MDBRow>
        <MDBCol md='4'>
        </MDBCol>
        <MDBCol md='4'>
          <MDBCard className="text-left">
            <MDBCardBody>
              <MDBCardTitle>Details</MDBCardTitle>
              <MDBCardText>
                <div className="grey-text">
                  <MDBInput focused required label="Full Name (or Nickname)" icon="user" group type="email" validate error="wrong" success="right" />
                  <FaVenusMars className="image-align" color='grey' size={35} />&nbsp;
                  <ToggleButtonGroup
                    value={gender}
                    exclusive
                    onChange={handleGender}>
                    <ToggleButton value="Male">
                      <FaMale color='#4285f4' size={25} />
                    </ToggleButton>
                    <ToggleButton value="Female">
                      <FaFemale color='violet' size={25} />
                    </ToggleButton>
                  </ToggleButtonGroup>
                  <br/>
                  <br/>
                  <div className='font-weight-bold blue-text'>
                  Your Age: {value}
                  </div>
                   <div className='fixed-image-height'>

                      { gender === 'Female' && value >= 1 && value < 3 && <Image src={Female1Img} /> }
                      { gender === 'Female' && value >= 3 && value < 7 && <Image src={Female2Img} /> }
                      { gender === 'Female' && value >= 7 && value < 10 && <Image src={Female3Img} /> }
                      { gender === 'Female' && value >= 10 && value < 14 && <Image src={Female4Img} /> }
                      { gender === 'Female' && value >= 14 && value < 22 && <Image src={Female5Img} /> }
                      { gender === 'Female' && value >= 22 && value < 30 && <Image src={Female6Img} /> }
                      { gender === 'Female' && value >= 30 && value < 36 && <Image src={Female7Img} /> }
                      { gender === 'Female' && value >= 36 && value < 44 && <Image src={Female8Img} /> }
                      { gender === 'Female' && value >= 44 && value < 52 && <Image src={Female9Img} /> }
                      { gender === 'Female' && value >= 52 && value < 60 && <Image src={Female10Img} /> }
                      { gender === 'Female' && value >= 60 && value < 85 && <Image src={Female11Img} /> }
                      { gender === 'Female' && value >= 85 && <Image src={Female12Img} /> }

                      { gender === 'Male' && value >= 1 && value < 3 && <Image src={Male1Img} /> }
                      { gender === 'Male' && value >= 3 && value < 7 && <Image src={Male2Img} /> }
                      { gender === 'Male' && value >= 7 && value < 10 && <Image src={Male3Img} /> }
                      { gender === 'Male' && value >= 10 && value < 14 && <Image src={Male4Img} /> }
                      { gender === 'Male' && value >= 14 && value < 22 && <Image src={Male5Img} /> }
                      { gender === 'Male' && value >= 22 && value < 30 && <Image src={Male6Img} /> }
                      { gender === 'Male' && value >= 30 && value < 36 && <Image src={Male7Img} /> }
                      { gender === 'Male' && value >= 36 && value < 44 && <Image src={Male8Img} /> }
                      { gender === 'Male' && value >= 44 && value < 57 && <Image src={Male9Img} /> }
                      { gender === 'Male' && value >= 57 && value < 75 && <Image src={Male10Img} /> }
                      { gender === 'Male' && value >= 75 && <Image src={Male11Img} /> }

                    </div>
                  <Grid container spacing={2}>
                    <Grid item>
                      <FaBabyCarriage color='grey' size={25} />
                    </Grid>
                    <Grid item xs>
                      <Slider min={1} max={100} value={value} onChange={handleChange} aria-labelledby="continuous-slider" />
                    </Grid>
                    <Grid item>
                      <FaBlind color='grey' size={25} />
                    </Grid>
                  </Grid>
                </div>
              </MDBCardText>
            </MDBCardBody>
          </MDBCard>
        </MDBCol>
        <MDBCol md='4'>
        </MDBCol>
      </MDBRow>
      <br/>
    </div>
  )
}